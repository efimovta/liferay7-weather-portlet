package edu.efimovta.liferay.osgi.weather.dto.apixu_json_structure;

/**
 * @author Efimov Timur
 * @version 1.0.1
 */
public class Day {
    private double avgtemp_c;
    private double mintemp_c;
    private double maxtemp_c;
    private Condition condition;

    public Condition getCondition() {
        return condition;
    }

    public double getAvgtemp_c() {
        return avgtemp_c;
    }

    public double getMintemp_c() {
        return mintemp_c;
    }

    public double getMaxtemp_c() {
        return maxtemp_c;
    }
}
