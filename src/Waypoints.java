import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Waypoint;

public class Waypoints {
	
	// Drive Straight
	public static Waypoint[] driveStraight = {
		new Waypoint(0, 0, Pathfinder.d2r(0)),
		new Waypoint(1, 0, 0)
	};
	
	public static Waypoint[] obsticleCourse = {
		new Waypoint(0, 0, 0),
		new Waypoint(1, 0, 0),
		new Waypoint(2, 1, 0),
		new Waypoint(3, 0, 0)
	};

}
