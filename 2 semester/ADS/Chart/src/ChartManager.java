import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.ValueMarker;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.RectangleAnchor;
import org.jfree.ui.TextAnchor;
import org.jfree.chart.ChartPanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ChartManager {
    public static void drawMarkers(JFreeChart chart) {
        XYPlot plot = chart.getXYPlot();

        // Create x-axis marker at 0
        ValueMarker xMarker = new ValueMarker(0);
        xMarker.setPaint(Color.BLACK);
        xMarker.setLabel("X Axis");
        xMarker.setLabelAnchor(RectangleAnchor.BOTTOM_RIGHT);
        xMarker.setLabelTextAnchor(TextAnchor.TOP_RIGHT);

        // Create y-axis marker at 0
        ValueMarker yMarker = new ValueMarker(0);
        yMarker.setPaint(Color.BLACK);
        yMarker.setLabel("Y Axis");
        yMarker.setLabelAnchor(RectangleAnchor.BOTTOM_RIGHT);
        yMarker.setLabelTextAnchor(TextAnchor.TOP_RIGHT);

        // Add markers to plot
        plot.addDomainMarker(xMarker);
        plot.addRangeMarker(yMarker);
    }

    static void updateChart(JFrame frame, JTextField aField, JTextField bField, JSlider startSlider, JSlider endSlider, JTextField stepField, JLabel formulaLabel, ChartPanel chartPanel, JFreeChart chart) {
        double A = Double.parseDouble(aField.getText());
        double B = Double.parseDouble(bField.getText());
        double start = startSlider.getValue() / 100.0;
        double end = endSlider.getValue() / 100.0;
        double step = Double.parseDouble(stepField.getText());
        formulaLabel.setText("x = A * cos(t) - B * cos(A / 2 * t); y = A * sin(t) - B * sin(A / 2 * t)");

        XYSeriesCollection dataset = getSeriesCollection(A, B, start, end, step);

        chart = ChartFactory.createXYLineChart(
                "Boring chart",
                "X",
                "Y",
                dataset,
                PlotOrientation.VERTICAL, false, false, true
        );

        drawMarkers(chart);
        chartPanel.setChart(chart);

        saveChartAsImage("Fedorych Volodymyr", "x = A * cos(t) - B * cos(A / 2 * t); y = A * sin(t) - B * sin(A / 2 * t)", frame, aField, bField, startSlider, endSlider, stepField, chart);
    }

    private static XYSeriesCollection getSeriesCollection(double A, double B, double start, double end, double step) {
        XYSeries series = new XYSeries("Series", false);

        for (double t = start; t <= end; t += step) {
            double x = A * Math.cos(t) - B * Math.cos(A / 2 * t);
            double y = A * Math.sin(t) - B * Math.sin(A / 2 * t);
            series.add(x, y);
        }

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);

        return dataset;
    }

    public static void saveChartAsImage(String authorName, String functionText, JFrame frame, JTextField aField, JTextField bField, JSlider startSlider, JSlider endSlider, JTextField stepField, JFreeChart chart) {
        BufferedImage chartImage = chart.createBufferedImage(600, 400);
        BufferedImage blankImage = new BufferedImage(600, 500, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = blankImage.createGraphics();

        // Set the background color to gray and fill the image with it
        g2d.setBackground(Color.WHITE);
        g2d.clearRect(0, 0, blankImage.getWidth(), blankImage.getHeight());

        // Draw the chart image onto the blank image
        g2d.drawImage(chartImage, 0, 0, null);

        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Arial", Font.PLAIN, 12));
        g2d.drawString(authorName, 10, blankImage.getHeight() - 60);
        g2d.drawString(functionText, 10, blankImage.getHeight() - 45);

        // Draw parameters with more space between them
        g2d.drawString("A: " + aField.getText(), 10, blankImage.getHeight() - 30);
        g2d.drawString("B: " + bField.getText(), 10, blankImage.getHeight() - 15);
        g2d.drawString("Start: " + startSlider.getValue(), 200, blankImage.getHeight() - 30);
        g2d.drawString("End: " + endSlider.getValue(), 200, blankImage.getHeight() - 15);
        g2d.drawString("Step: " + stepField.getText(), 400, blankImage.getHeight() - 30);

        try {
            ImageIO.write(blankImage, "png", new File("Function.png"));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(frame, "Failed to save chart: " + e.getMessage());
        }
        g2d.dispose();
    }

    public static JFreeChart createChart() {
        return ChartFactory.createXYLineChart(
                "Boring chart",
                "X",
                "Y",
                null,
                PlotOrientation.VERTICAL, false, false, true
        );
    }
}
