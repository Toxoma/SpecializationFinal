package org.example;

import org.jfree.ui.RefineryUtilities;

public class App 
{
    public static void main( String[] args )
    {
        PieChartExploded demo = new PieChartExploded("Диаграмма");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
    }
}
