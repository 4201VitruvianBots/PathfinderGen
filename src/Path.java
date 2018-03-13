import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;

public class Path {
	Trajectory.FitMethod fitMethod = Trajectory.FitMethod.HERMITE_CUBIC; 
	double max_vel = 2;
	double max_accel = 2;
	double max_jerk = 60;
	int samples = Trajectory.Config.SAMPLES_HIGH;
	double period = 0.05;
	
	public String name;
	public Waypoint[] path;
	
	Trajectory.Config config;
	
	public Path(String name, Waypoint[] waypoints) {
		reconfigureSettings();
	}
	
	public void setMaxVel(double max_vel) {
		this.max_vel = max_vel;
		reconfigureSettings();
	}
	
	public void setMaxAccel(double max_accel) {
		this.max_accel = max_accel;
		reconfigureSettings();
	}
	
	public void setMaxJerk(double max_jerk) {
		this.max_jerk = max_jerk;
		reconfigureSettings();
	}
	
	public void setSamples(Trajectory.FitMethod fitMethod) {
		this.fitMethod = fitMethod;
		reconfigureSettings();
	}
	
	public void setSamples(int samples) {
		this.samples = samples;
		reconfigureSettings();
	}
	
	public void setPeriod(double period) {
		this.period = period;
		reconfigureSettings();
	}
	
	public void reconfigureSettings() {
		config = new Trajectory.Config(fitMethod, samples, period, max_vel, max_accel, max_jerk);
	}
}
