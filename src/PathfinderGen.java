import java.io.File;
import java.util.ArrayList;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Trajectory.FitMethod;
import jaci.pathfinder.modifiers.TankModifier;

public class PathfinderGen {
	public static double max_vel = 2;
	public static double max_accel = 2;
	public static double max_jerk = 10;
	public static int samples = Trajectory.Config.SAMPLES_HIGH;
	public static Trajectory.FitMethod fitMethod = Trajectory.FitMethod.HERMITE_CUBIC;
	public static double period = 0.05;
	
	static int index;
	
	static ArrayList<Path> path = new ArrayList<>();
	static TankModifier modifier;
	
	public static void main(String[] args){
		initializePaths();

		Trajectory trajectory;
		for(int i = 0; i < path.size(); i++) {
			try {
				System.out.println("Generating Path...");
				trajectory = Pathfinder.generate(path.get(i).path, path.get(i).config);
				System.out.println("Path Generated!");
				
				modifier = new TankModifier(trajectory).modify(0.7639);
				
				File leftCsvFile = new File("Pathfinder/" + path.get(i).name + "_Left.csv");		// Remember to rename a successful file, otherwise it will be overwritten
				Pathfinder.writeToCSV(leftCsvFile, modifier.getLeftTrajectory());
				File rightCsvFile = new File("Pathfinder/" + path.get(i).name + "_Right.csv");		// Remember to rename a successful file, otherwise it will be overwritten
				Pathfinder.writeToCSV(rightCsvFile, modifier.getRightTrajectory());
				if(leftCsvFile.exists() && rightCsvFile.exists()) {
					System.out.println("Success! File \"" + path.get(i).name + "_Left.csv\" was generated!");
					System.out.println("Success! File \"" + path.get(i).name + "_Right.csv\" was generated!");
				} else {
					System.out.println("Error: File \"" + path.get(i).name + "_Left.csv\" was not created");
					System.out.println("Error: File \"" + path.get(i).name + "_Right.csv\" was not created");
				}
				index = i;
			} catch(Exception e){
				System.out.println("Error: " + e.getMessage());
			}
		}

		System.out.println("Number of Paths Generated: " + index);
	}
	
	static void initializePaths(){
		path.add(new Path("leftStartToLeftScaleReverse", Waypoints.leftStartToLeftScaleReverse));
		path.get(0).setMaxVel(2);
		path.get(0).setMaxAccel(2);
		//path.add(new Path("leftStartToLeftSwitchReverseOne", Waypoints.leftStartToLeftSwitchReverseOne));
		//path.add(new Path("leftStartToLeftSwitchReverseTwo", Waypoints.leftStartToLeftSwitchReverseTwo));
		//path.add(new Path("leftStartToRightSwitchNearReverseOne", Waypoints.leftStartToRightSwitchNearReverseOne));
		//path.add(new Path("leftStartToRightSwitchNearReverseTwo", Waypoints.leftStartToRightSwitchNearReverseTwo));
		//path.add(new Path("leftStartToRightSwitchFarReverseOne", Waypoints.leftStartToRightSwitchFarReverseOne));
		//path.add(new Path("leftStartToRightSwitchFarReverseTwo", Waypoints.leftStartToRightSwitchFarReverseTwo));
		path.add(new Path("leftScaleToCubeOneReverse", Waypoints.leftScaleToCubeOneReverse));
		path.add(new Path("leftStartToRightScale", Waypoints.leftStartToRightScale));
		path.add(new Path("rightStartToRightScaleReverse", Waypoints.rightStartToRightScaleReverse));
		//path.add(new Path("centerAutoLeft", Waypoints.centerAutoLeft));
		//path.add(new Path("centerAutoRight", Waypoints.centerAutoRight));
		/*
		path.add(new Path("driveStraight", Waypoints.driveStraight));
		path.add(new Path("driveCalibration", Waypoints.driveCalibration));
		path.add(new Path("centerAutoLeft", Waypoints.centerAutoLeft));
		path.add(new Path("centerAutoRight", Waypoints.centerAutoRight));
		path.add(new Path("rightStartToRightSwitch", Waypoints.rightStartToRightSwitch));
		path.add(new Path("rightStartToRightScaleReverse", Waypoints.rightStartToRightScaleReverse));
		path.get(5).setMaxVel(2);
		path.get(5).setMaxAccel(2);
		path.add(new Path("rightScaleToCubeOneReverse", Waypoints.rightScaleToCubeOneReverse));
		path.get(6).setMaxVel(4);
		path.get(6).setMaxAccel(4);
		path.add(new Path("cubeOneToRightScaleReverse", Waypoints.cubeOneToRightScaleReverse));
		path.get(7).setMaxVel(4);
		path.get(7).setMaxAccel(4);
		/*
		path.add(new Path("rightStartToRightScale", Waypoints.rightStartToRightScale));
		path.add(new Path("rightScaleToCubeOne", Waypoints.rightScaleToCubeOne));
		path.add(new Path("cubeOneToRightScale", Waypoints.cubeOneToRightScale));
		
		path.add(new Path("leftStartToLeftSwitch", Waypoints.leftStartToLeftSwitch));
		path.add(new Path("leftStartToLeftScale", Waypoints.leftStartToLeftScale));
		path.add(new Path("rightStartToLeftScale", Waypoints.rightStartToLeftScale));
		path.add(new Path("rightStartToLeftScaleReverse", Waypoints.rightStartToLeftScaleReverse));
		//path.get(9).setFitMethod(FitMethod.HERMITE_QUINTIC);
		//path.get(9).setMaxVel(1);
		//path.get(9).setMaxAccel(1);
		//*/
	}
}
