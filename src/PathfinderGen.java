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
	public static Trajectory.FitMethod fitMethod = FitMethod.HERMITE_CUBIC;
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
		// Straight Autos
		
		//path.add(new Path("driveStraight", Waypoints.driveStraight));
		//path.add(new Path("driveCalibration", Waypoints.driveCalibration));
		path.add(new Path("scaleToEdgeCubeLeft", Waypoints.scaleToEdgeCubeLeft));												// To Redo/Improve
		path.get(path.size() - 1).setMaxVel(1.75);									// To Redo/Improve
		path.get(path.size() - 1).setMaxAccel(1.75);									// To Redo/Improve	
		path.add(new Path("scaleToEdgeCubeRight", Waypoints.scaleToEdgeCubeLeft));												// To Redo/Improve
		path.get(path.size() - 1).setMaxVel(1.75);									// To Redo/Improve
		path.get(path.size() - 1).setMaxAccel(1.75);						
		path.add(new Path("edgeCubeToScaleDrop", Waypoints.edgeCubeToScaleDrop));												// To Redo/Improve
		path.get(path.size() - 1).setMaxVel(4);									// To Redo/Improve
		path.get(path.size() - 1).setMaxAccel(4);									// To Redo/Improve	
		path.add(new Path("edgeCubeToScaleShoot", Waypoints.edgeCubeToScaleShoot));												// To Redo/Improve
		path.get(path.size() - 1).setMaxVel(4);									// To Redo/Improve
		path.get(path.size() - 1).setMaxAccel(4);			
		path.add(new Path("edgeCubeFarToScale", Waypoints.edgeCubeFarToScale));												// To Redo/Improve
		path.get(path.size() - 1).setMaxVel(4);									// To Redo/Improve
		path.get(path.size() - 1).setMaxAccel(4);									// To Redo/Improve	
		path.add(new Path("edgeCubeToSwitch", Waypoints.edgeCubeToSwitch));											// To Test (?)
		path.get(path.size() - 1).setMaxVel(4);									// To Redo/Improve
		path.get(path.size() - 1).setMaxAccel(4);									// To Redo/Improve	
		path.add(new Path("leftScaleToEdgeCubeFar", Waypoints.leftScaleToEdgeCubeFar));												// To Redo/Improve
		path.get(path.size() - 1).setMaxVel(1);									// To Redo/Improve
		path.get(path.size() - 1).setMaxAccel(1);			
		path.add(new Path("rightScaleToEdgeCubeFar", Waypoints.rightScaleToEdgeCubeFar));												// To Redo/Improve
		path.get(path.size() - 1).setMaxVel(1);									// To Redo/Improve
		path.get(path.size() - 1).setMaxAccel(1);									// To Redo/Improve	
		
		// Center Autos
		path.add(new Path("centerAutoLeft", Waypoints.centerAutoLeft));
		path.get(path.size() - 1).setMaxVel(1.5);									// To Redo/Improve
		path.get(path.size() - 1).setMaxAccel(1.5);									// To Redo/Improve	
		path.add(new Path("centerAutoRight", Waypoints.centerAutoRight));
		path.get(path.size() - 1).setMaxVel(1.5);									// To Redo/Improve
		path.get(path.size() - 1).setMaxAccel(1.5);									// To Redo/Improve	
		path.add(new Path("switchBackLeft", Waypoints.switchBackLeft));
		path.get(path.size() - 1).setMaxVel(1.75);								
		path.get(path.size() - 1).setMaxAccel(1.75);
		path.add(new Path("switchBackRight", Waypoints.switchBackRight));
		path.get(path.size() - 1).setMaxVel(1.75);								
		path.get(path.size() - 1).setMaxAccel(1.75);
		path.add(new Path("centerAutoGrabCube", Waypoints.centerAutoGrabCube));								
		path.get(path.size() - 1).setMaxVel(1.75);								
		path.get(path.size() - 1).setMaxAccel(1.75);
		path.add(new Path("centerAutoGrabCubeReverse", Waypoints.centerAutoGrabCube));								
		path.get(path.size() - 1).setMaxVel(1.75);								
		path.get(path.size() - 1).setMaxAccel(1.75);
		path.add(new Path("centerAutoLeftFaster", Waypoints.centerAutoLeft));
		path.get(path.size() - 1).setMaxVel(1.75);									// To Redo/Improve
		path.get(path.size() - 1).setMaxAccel(1.75);									// To Redo/Improve	
		path.add(new Path("centerAutoRightFaster", Waypoints.centerAutoRight));
		path.get(path.size() - 1).setMaxVel(1.75);									// To Redo/Improve
		path.get(path.size() - 1).setMaxAccel(1.75);									// To Redo/Improve	
		//*/
		
		// Right Autos
		/*
		path.add(new Path("rightStartToRightScale", Waypoints.rightStartToRightScale));								// To Redo/Improve
		path.add(new Path("rightStartToLeftScale", Waypoints.rightStartToLeftScale));									// To Redo/Improve
		path.add(new Path("rightStartToRightSwitchReverseOne", Waypoints.rightStartToRightSwitchReverseOne));			// To Test
		path.add(new Path("rightStartToRightSwitchReverseTwo", Waypoints.rightStartToRightSwitchReverseTwo));			// To Test
		path.add(new Path("rightStartToLeftSwitchNearReverseOne", Waypoints.rightStartToLeftSwitchNearReverseOne));	// To Test
		path.add(new Path("rightStartToLeftSwitchNearReverseTwo", Waypoints.rightStartToLeftSwitchNearReverseTwo));	// To Test
		path.add(new Path("rightStartToLeftSwitchFarReverseOne", Waypoints.rightStartToLeftSwitchFarReverseOne));		// To Test
		path.add(new Path("rightStartToLeftSwitchFarReverseTwo", Waypoints.rightStartToLeftSwitchFarReverseTwo));		// To Test
		path.add(new Path("rightScaleToCubeSix", Waypoints.rightScaleToCubeSix));
		//*/
				
		// Left Autos
		/*
		path.add(new Path("leftStartToLeftScale", Waypoints.leftStartToLeftScale));										// To Redo/Improve
		path.add(new Path("leftStartToRightScale", Waypoints.leftStartToRightScale));									// To Redo/Improve
		path.add(new Path("leftStartToLeftSwitchReverseOne", Waypoints.leftStartToLeftSwitchReverseOne));
		path.add(new Path("leftStartToLeftSwitchReverseTwo", Waypoints.leftStartToLeftSwitchReverseTwo));
		path.add(new Path("leftStartToRightSwitchNearReverseOne", Waypoints.leftStartToRightSwitchNearReverseOne));
		path.add(new Path("leftStartToRightSwitchNearReverseTwo", Waypoints.leftStartToRightSwitchNearReverseTwo));
		path.add(new Path("leftStartToRightSwitchFarReverseOne", Waypoints.leftStartToRightSwitchFarReverseOne));
		path.add(new Path("leftStartToRightSwitchFarReverseTwo", Waypoints.leftStartToRightSwitchFarReverseTwo));
		path.add(new Path("leftScaleToCubeOne", Waypoints.leftScaleToCubeOne));
		//*/
	}
}
