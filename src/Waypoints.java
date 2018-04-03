import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Waypoint;

public class Waypoints {
	
	// Drive Straight
	public static Waypoint[] driveStraight = {
		new Waypoint(0, 0, 0),
		new Waypoint(5, 0, 0)
	};
	
	public static Waypoint[] driveCalibration = {
		new Waypoint(0, 0, 0),
		new Waypoint(3, 0, 0)
	};
	
	public static Waypoint[] rightStartToLeftScaleReverse = {
		new Waypoint(0, 0, 0),
		new Waypoint(3.3333, -0.35, 0),
		new Waypoint(4.745, -0.35, 0),
		new Waypoint(5.745, 0.5, Pathfinder.d2r(90)),
		new Waypoint(5.745, 4.5, Pathfinder.d2r(90)),
		new Waypoint(6.75, 5.55, 0),						// new Waypoint(7.3333, 5.3889, 0),
		new Waypoint(7, 5.55, 0),		
	};
	
	// Center Autos
	public static Waypoint[] centerAutoLeft = {
		new Waypoint(0, 2.8333, 0),
		new Waypoint(3.05, 4.4, 0)				//new Waypoint(3.1, 4.5, 0)
	};
	
	public static Waypoint[] centerAutoRight = {
		new Waypoint(0, 2.8333, 0),
		new Waypoint(3.05, 1.4, 0)				//new Waypoint(3.1, 1.5, 0)
	};
	
	// Right Autos
	public static Waypoint[] rightStartToRightSwitch = {
		new Waypoint(0, 0, 0),
		new Waypoint(3.3333, -0.5, 0),
		new Waypoint(4.3333, 0.5, Pathfinder.d2r(90))
	};
	
	public static Waypoint[] rightStartToRightScale = {
		new Waypoint(0, 0, 0),
		new Waypoint(3.3333, -0.4, 0),
		new Waypoint(5.3333, -0.4, 0),
		new Waypoint(7.1, 0.8889, 0),
	};
	
	public static Waypoint[] rightScaleToCubeOne = {
		new Waypoint(7.1, 0.8889, 0),
		new Waypoint(6, 0.8889, 0),
	};
	
	public static Waypoint[] cubeOneToRightScale = {
		new Waypoint(6, 0.8889, 0),
		new Waypoint(7.1, 0.8889, 0),
	};
	
	public static Waypoint[] rightStartToRightScaleReverse = {
		new Waypoint(0, 0, 0),
		new Waypoint(5.25, 0, 0),
		new Waypoint(7.1, 1.4, 0),
	};
	
	public static Waypoint[] rightScaleToCubeOneReverse = {
		new Waypoint(5.5, 0.8889, 0),
		new Waypoint(7.1, 0.8889, 0),
	};
	
	public static Waypoint[] cubeOneToRightScaleReverse = {
		new Waypoint(5.5, 0.8889, 0),
		new Waypoint(7.1, 0.8889, 0),
	};
	
	/*
	public static Waypoint[] rightStartToLeftSwitch = {
		new Waypoint(0, 0, 0),
		new Waypoint(3.3333, -0.5, 0),
		new Waypoint(5.3333, -0.5, 0),
		new Waypoint(6.3333, 0.5, Pathfinder.d2r(90)),
		new Waypoint(6.3333, 4.7778, Pathfinder.d2r(90)),
	};
	*/
	public static Waypoint[] rightStartToLeftScale = {
		new Waypoint(0, 0, 0),
		new Waypoint(3.3333, -0.4, 0),
		new Waypoint(5.3333, -0.4, 0),
		new Waypoint(6.5, 0.5, Pathfinder.d2r(90)),
		new Waypoint(6.5, 4.5, Pathfinder.d2r(90)),
		new Waypoint(7.5, 5.8, 0),						// new Waypoint(7.3333, 5.3889, 0),
		new Waypoint(8, 5.8, 0),						// new Waypoint(7.3333, 5.3889, 0),
		
		/*
		new Waypoint(0, 0, 0),
		new Waypoint(3.3333, -0.5, 0),
		new Waypoint(5, -0.5, 0),
		new Waypoint(6, 0.5, Pathfinder.d2r(90)),
		new Waypoint(6, 4.7778, Pathfinder.d2r(90)),
		new Waypoint(7.1, 5.25, 0),					// new Waypoint(7.3333, 5.3889, 0),
		//new Waypoint(7.3333, 5.3889, 0),
		*/
	};
	
	// Left Autos
	public static Waypoint[] leftStartToLeftSwitch = {
		new Waypoint(0, 6.2778, 0),
		new Waypoint(3.3333, 6.7778, 0),
		new Waypoint(4.3333, 5.7778, Pathfinder.d2r(90)),
	};
	
	
	// 4/2/2018 5:01 PM
	public static Waypoint[] leftStartToLeftScaleReverse = {
		new Waypoint(0, 0, 0),
		new Waypoint(5.25, 0, 0),
		new Waypoint(7.1, -1.4, 0),
	};
	
	// 4/2/2018 5:12 PM
	public static Waypoint[] leftStartToLeftSwitchReverseOne = {
		new Waypoint(0, 0, 0),
		new Waypoint(5.3333, 0.4, 0),
	};
	public static Waypoint[] leftStartToLeftSwitchReverseTwo = {
		new Waypoint(0, 0, 0),
		new Waypoint(1.75, 0.75, Pathfinder.d2r(90)),
	};
	
	// 4/2/2018 5:?? PM
	public static Waypoint[] leftStartToRightSwitchNearReverseOne = {
		new Waypoint(0, 0, 0),
		new Waypoint(3, 0, 0),
	};
	public static Waypoint[] leftStartToRightSwitchNearReverseTwo = {
		new Waypoint(0, 0, 0),
		new Waypoint(2.2, 1, Pathfinder.d2r(90)),
		new Waypoint(2.2, 3.75, Pathfinder.d2r(90)),
		new Waypoint(0.9, 5.1, Pathfinder.d2r(180)),
	};
	
	// 4/2/2018 5:51 PM
	public static Waypoint[] leftStartToRightSwitchFarReverseOne = {
		new Waypoint(0, 0, 0),
		new Waypoint(7, 0, 0),
	};
	public static Waypoint[] leftStartToRightSwitchFarReverseTwo = {
		new Waypoint(0, 0, 0),
		new Waypoint(1.3, 1, Pathfinder.d2r(90)),
		new Waypoint(1.3, 5.4, Pathfinder.d2r(90)),
		new Waypoint(2.2, 6.4, 0),
		new Waypoint(4.7, 5.7, Pathfinder.d2r(-90)),
	};
	
	// 4/2/2018 7:43 PM
	public static Waypoint[] leftScaleToCubeOneReverse = {
		new Waypoint(0, 0, 0),
		new Waypoint(1.3, 1, Pathfinder.d2r(90)),
		new Waypoint(1.3, 3.3, Pathfinder.d2r(90)),
		new Waypoint(2.4, 3.9, 0),
	};
		
	public static Waypoint[] leftStartToRightScale = {
		new Waypoint(0, 0, 0),
		new Waypoint(3.3333, 0.4, 0),
		new Waypoint(5.3333, 0.4, 0),
		new Waypoint(6.3, -0.5, Pathfinder.d2r(-90)),
		new Waypoint(6.3, -4, Pathfinder.d2r(-90)),
		new Waypoint(7, -5.4, 0),						// new Waypoint(7.3333, 5.3889, 0),
		new Waypoint(7.2, -5.4, 0),
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
