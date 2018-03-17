import java.io.File;
import java.util.ArrayList;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.modifiers.TankModifier;

public class PathfinderGen {
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
			} catch(Exception e){
				System.out.println("Error: " + e.getMessage());
			}
		}
	}
	
	static void initializePaths(){
		path.add(new Path("driveStraight", Waypoints.driveStraight));
		path.add(new Path("centerAutoLeft", Waypoints.centerAutoLeft));
		path.add(new Path("centerAutoRight", Waypoints.centerAutoRight));
		path.add(new Path("rightStartToRightSwitch", Waypoints.rightStartToRightSwitch));
		path.add(new Path("rightStartToRightScale", Waypoints.rightStartToRightScale));
		path.add(new Path("leftStartToLeftSwitch", Waypoints.leftStartToLeftSwitch));
		path.add(new Path("leftStartToLeftScale", Waypoints.leftStartToLeftScale));
	}
}
