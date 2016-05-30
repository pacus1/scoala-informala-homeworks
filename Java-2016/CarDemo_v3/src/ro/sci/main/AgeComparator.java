package ro.sci.main;

import java.util.Comparator;

import ro.sci.VehicleGen.Car;

public abstract class AgeComparator implements Comparator {
	
	    public int compare(Car o1, Car o2) {
	        // descending order (ascending order would be: o1.getGrade()-o2.getGrade())
	        return o2.getProductionYear() - o1.getProductionYear();
	    }
	
	
}
