import java.io.File;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;


public class PathfinderGen {
	static Path[] path;
	static int index;
	
	public static void main(String[] args){
		initializePaths();

		Trajectory trajectory;
		for(int i = 0; i < path.length; i++) {
			try {
				System.out.println("Generating Path...");
				trajectory = Pathfinder.generate(path[i].path, path[i].config);
				System.out.println("Path Generated!");
				
				File csvFile = new File("Pathfinder/" + path[i].name + ".csv");		// Remember to rename a successful file, otherwise it will be overwritten
				Pathfinder.writeToCSV(csvFile, trajectory);
				if(csvFile.exists())
					System.out.println("Success! File \"" + path[i].name + ".csv\" was generated!");
				else
					System.out.println("Error: File \"" + path[i].name + ".csv\" was not created");
			} catch(Exception e){
				System.out.println("Error: " + e.getMessage());
			}
		}
	}
	
	static void initializePaths(){
		path[index++] = new Path("driveStraight", Waypoints.driveStraight);
		path[index++] = new Path("centerAutoLeft", Waypoints.centerAutoLeft);
		path[index++] = new Path("centerAutoRight", Waypoints.centerAutoRight);
	}
}
