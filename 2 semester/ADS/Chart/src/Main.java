import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import javax.swing.*;
import java.awt.*;

public class Main {
    private static JTextField aField, bField, stepField;
    private static JSlider startSlider, endSlider;
    private static final JLabel formulaLabel = new JLabel("x = A * cos(t) - B * cos(A / 2 * t), y = A * sin(t) - B * sin(A / 2 * t)");
    private static ChartPanel chartPanel;
    private static JFreeChart chart;
    static JFrame frame = new JFrame();

    public static void main(String[] args) {
        drawUI();

        chart = ChartManager.createChart();
        ChartManager.updateChart(frame, aField, bField, startSlider, endSlider, stepField, formulaLabel, chartPanel, chart);
    }

    private static void drawUI() {
        frame.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(6, 2));
        aField = addParameterField(inputPanel, "A", "8.0");
        bField = addParameterField(inputPanel, "B", "2.0");
        startSlider = addParameterSlider(inputPanel, "Start", 0, (int) (2 * Math.PI * 100), 0);
        endSlider = addParameterSlider(inputPanel, "End", 0, (int) (2 * Math.PI * 100), (int) (2 * Math.PI * 100));
        stepField = addParameterField(inputPanel, "Step", "0.0075");

        JButton button = new JButton("Update Chart");
        button.addActionListener(e ->
                ChartManager.updateChart(frame, aField, bField, startSlider, endSlider, stepField, formulaLabel, chartPanel, chart));
        inputPanel.add(button);
        frame.add(inputPanel, BorderLayout.WEST);
        inputPanel.add(new JLabel("Fedorych Volodymyr"));

        chartPanel = new ChartPanel(null);

        frame.setSize(1000, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        formulaLabel.setHorizontalAlignment(JLabel.CENTER);

        JPanel chartAndFormulaPanel = new JPanel(new BorderLayout());
        chartAndFormulaPanel.add(chartPanel, BorderLayout.CENTER);
        chartAndFormulaPanel.add(formulaLabel, BorderLayout.SOUTH);

        frame.add(chartAndFormulaPanel, BorderLayout.CENTER);
    }

    public static JTextField addParameterField(JPanel panel, String name, String defaultValue) {
        panel.add(new JLabel(name));
        JTextField field = new JTextField(defaultValue);
        panel.add(field);
        return field;
    }

    public static JSlider addParameterSlider(JPanel panel, String name, int min, int max, int value) {
        panel.add(new JLabel(name));
        JSlider slider = new JSlider(min, max, value);
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing((int) (Math.PI * 100));
        slider.addChangeListener(e -> {
            JSlider source = (JSlider)e.getSource();
            if (!source.getValueIsAdjusting()) {
                ChartManager.updateChart(frame, Main.aField, bField, startSlider, endSlider, stepField, formulaLabel, chartPanel, chart);
            }
        });
        panel.add(slider);
        return slider;
    }
}
