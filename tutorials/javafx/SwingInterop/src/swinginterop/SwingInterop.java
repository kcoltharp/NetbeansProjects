package swinginterop;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import javafx.embed.swing.JFXPanel;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.Chart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * SwingInterop
 *
 * Note using the browser might require setting the properties - http.proxyHost
 * - http.proxyPort
 *
 * e.g. -Dhttp.proxyHost=webcache.mydomain.com -Dhttp.proxyPort=8080
 *
 */
public class SwingInterop extends JApplet {

    private static final int PANEL_WIDTH_INT = 675;
    private static final int PANEL_HEIGHT_INT = 400;
    private static final int TABLE_PANEL_HEIGHT_INT = 100;
    private static JFXPanel chartFxPanel;
    private static SampleTableModel tableModel;
    private Chart chart;
    private Pane browser;

    public void init() {

        tableModel = new SampleTableModel();
        // create javafx panel for charts
        chartFxPanel = new JFXPanel();
        chartFxPanel.setPreferredSize(new Dimension(PANEL_WIDTH_INT, PANEL_HEIGHT_INT));

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        //JTable
        JTable table = new JTable(tableModel);
        table.setAutoCreateRowSorter(true);
        table.setGridColor(Color.DARK_GRAY);
        SwingInterop.DecimalFormatRenderer renderer = new SwingInterop.DecimalFormatRenderer();
        renderer.setHorizontalAlignment(JLabel.RIGHT);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(renderer);
        }

        JScrollPane tablePanel = new JScrollPane(table);
        tablePanel.setPreferredSize(new Dimension(PANEL_WIDTH_INT, TABLE_PANEL_HEIGHT_INT));

        JPanel chartTablePanel = new JPanel();
        chartTablePanel.setLayout(new BorderLayout());
        chartTablePanel.add(chartFxPanel, BorderLayout.CENTER);

        panel.add(chartTablePanel, BorderLayout.CENTER);
        panel.add(tablePanel, BorderLayout.SOUTH);

        add(panel, BorderLayout.CENTER);

        // create JavaFX scene
        Platform.runLater(new Runnable() {
            public void run() {
                createScene();
            }
        });

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                try {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
                } catch (Exception e) {
                }

                JFrame frame = new JFrame("JavaFX 2.0 in Swing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                JApplet applet = new SwingInterop();
                applet.init();

                frame.setContentPane(applet.getContentPane());

                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                applet.start();
            }
        });
    }

    private void createScene() {
        chart = createBarChart();
        chartFxPanel.setScene(new Scene(chart));
    }

    private BarChart createBarChart() {
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setCategories(FXCollections.<String>observableArrayList(tableModel.getColumnNames()));
        xAxis.setLabel("Year");

        double tickUnit = tableModel.getTickUnit();

        NumberAxis yAxis = new NumberAxis();
        yAxis.setTickUnit(tickUnit);
        yAxis.setLabel("Units Sold");

        final BarChart chart = new BarChart(xAxis, yAxis, tableModel.getBarChartData());
        tableModel.addTableModelListener(new TableModelListener() {

            public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.UPDATE) {
                    final int row = e.getFirstRow();
                    final int column = e.getColumn();
                    final Object value = ((SampleTableModel) e.getSource()).getValueAt(row, column);

                    Platform.runLater(new Runnable() {
                        public void run() {
                            XYChart.Series<String, Number> s = (XYChart.Series<String, Number>) chart.getData().get(row);
                            BarChart.Data data = s.getData().get(column);
                            data.setYValue(value);
                        }
                    });
                }
            }
        });
        return chart;
    }

    private static class DecimalFormatRenderer extends DefaultTableCellRenderer {

        private static final DecimalFormat formatter = new DecimalFormat("#.0");

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            value = formatter.format((Number) value);
            return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        }
    }
}
