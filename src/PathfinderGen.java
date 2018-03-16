import java.io.File;
import java.util.ArrayList;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;

public class PathfinderGen {
	static ArrayList<Path> path = new ArrayList<>();
	
	public static void main(String[] args){
		initializePaths();

		Trajectory trajectory;
		for(int i = 0; i < path.size(); i++) {
			try {
				System.out.println("Generating Path...");
				trajectory = Pathfinder.generate(path.get(i).path, path.get(i).config);
				System.out.println("Path Generated!");
				
				File csvFile = new File("Pathfinder/" + path.get(i).name + ".csv");		// Remember to rename a successful file, otherwise it will be overwritten
				Pathfinder.writeToCSV(csvFile, trajectory);
				if(csvFile.exists())
					System.out.println("Success! File \"" + path.get(i).name + ".csv\" was generated!");
				else
					System.out.println("Error: File \"" + path.get(i).name + ".csv\" was not created");
			} catch(Exception e){
				System.out.println("Error: " + e.getMessage());
			}
		}
	}
	
	static void initializePaths(){
		path.add(new Path("driveStraight", Waypoints.driveStraight));
		path.add(new Path("centerAutoLeft", Waypoints.centerAutoLeft));
		path.add(new Path("centerAutoRight", Waypoints.centerAutoRight));
	}
}
