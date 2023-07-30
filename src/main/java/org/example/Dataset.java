package org.example;

import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

public class Dataset
{
    public static final String[] SECTIONS    = {
            "собаки",
            "кошки",
            "хомяки",
            "лошади",
            "верблюды",
            "ослы"
    };
    public static final double[] VALUES = {
            2,
            4,
            10,
            2,
            4,
            10
    };

    public static PieDataset createPieDataset(final double[] expenses)
    {
        DefaultPieDataset dataset = new DefaultPieDataset();
        for (int i = 0; i < SECTIONS.length; i++)
            dataset.setValue(SECTIONS[i], (expenses[i]));
        return dataset;
    }
}
