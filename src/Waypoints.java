import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Waypoint;

public class Waypoints {
	
	// Drive Straight
	public static Waypoint[] driveStraight = {
		new Waypoint(0, 0, 0),
		new Waypoint(5, 0, 0)
	};
	
	// Center Autos
	public static Waypoint[] centerAutoLeft = {
		new Waypoint(0, 2.8333, 0),
		new Waypoint(3.1, 4.5, 0)
	};
	
	public static Waypoint[] centerAutoRight = {
		new Waypoint(0, 2.8333, 0),
		new Waypoint(3.1, 1.5, 0)
	};
	
	// Right Autos
	public static Waypoint[] rightStartToRightSwitch = {
		new Waypoint(0, 0, 0),
		new Waypoint(3.3333, -0.5, 0),
		new Waypoint(4.3333, 0.5, Pathfinder.d2r(90))
	};
	
	public static Waypoint[] rightStartToRightScale = {
		new Waypoint(0, 0, 0),
		new Waypoint(3.3333, -0.5, 0),
		new Waypoint(5.3333, -0.5, 0),
		new Waypoint(7.1, 0.8889, 0),
	};
	
	/*
	public static Waypoint[] rightStartToLeftSwitch = {
		new Waypoint(0, 0, 0),
		new Waypoint(5, 0, 0)
	};
	
	public static Waypoint[] rightStartToLeftScale = {
		new Waypoint(0, 0, 0),
		new Waypoint(5, 0, 0)
	};
	*/
	// Left Autos
	public static Waypoint[] leftStartToLeftSwitch = {
		new Waypoint(0, 6.2778, 0),
		new Waypoint(3.3333, 6.7778, 0),
		new Waypoint(4.3333, 5.7778, Pathfinder.d2r(-90)),
	};
	
	public static Waypoint[] leftStartToLeftScale = {
		new Waypoint(0, 6.2778, 0),
		new Waypoint(3.3333, 6.7778, 0),
		new Waypoint(5.3333, 6.7778, 0),
		new Waypoint(7.1, 5.3889, 0),
	};
	/*
	public static Waypoint[] leftStartToRightSwitch = {
		new Waypoint(0, 0, 0),
		new Waypoint(5, 0, 0)
	};
	
	public static Waypoint[] leftStartToRightScale = {
		new Waypoint(0, 0, 0),
		new Waypoint(5, 0, 0)
	};
	*/
}
