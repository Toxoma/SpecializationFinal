package org.example;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;

import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;

import java.awt.*;

public class PieChartExploded extends ApplicationFrame
{
    PieDataset dataset = null;
    JFreeChart chart = null;

    public PieChartExploded(final String title)
    {
        super(title);
        dataset = Dataset.createPieDataset(Dataset.VALUES);
        createChart(dataset);

        // Размещение диаграммы в панели
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(600, 400));
        setContentPane(chartPanel);
    }
    private void createChart(final PieDataset dataset)
    {
        chart = ChartFactory.createPieChart("Друзья человека",
                dataset, true, true, false);
        PiePlot plot = (PiePlot) chart.getPlot();

        plot.setSectionPaint("собаки", new Color(255, 0, 0));
        plot.setSectionPaint("кошки",  new Color(255, 0, 0));
        plot.setSectionPaint("хомяки",  new Color(255, 0, 0));

        plot.setSectionPaint("лошади", new Color(200, 255, 200));
        plot.setSectionPaint("верблюды", new Color(200, 255, 200));
        plot.setSectionPaint("ослы", new Color(200, 255, 200));
//        plot.setExplodePercent(Dataset.SECTIONS[3], 0.20);
    }
}