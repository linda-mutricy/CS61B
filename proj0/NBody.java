public class NBody {
/**A class that runs the simulation of a universe specified in a data file. */

//input format is a text file containing information for a universe in SI units.
//int n represents the # of plants.
//double r is the radius of the universe -- determines the scaling of drawing window.

//Planet[] n rows, w/ each row containing 6 values
//xxPos yyPos; xxVel yyVel; mass; imgFileName; - found in the images dir

public static double readRadius(String txt) {
	In in = new In(txt);
	int numberPlanets = in.readInt();
	double radius = in.readDouble();
	return radius;

}

public static Planet[] readPlanets(String txt) {
	In in = new In(txt);
	int numberPlanets = in.readInt();
	double radius = in.readDouble();
	Planet[] planets = new Planet[numberPlanets];
	int i = 0;
	//this is where building the array starts.
	while (!in.isEmpty() && i < planets.length) {
		double xP = in.readDouble();
		double yP = in.readDouble();
		double xV = in.readDouble();
		double yV = in.readDouble();
		double m = in.readDouble();
		//concatenation of relevant string
		String img = "images/" + in.readString();
		Planet newPlanet = new Planet(xP, yP, xV, yV, m, img);
		planets[i] = newPlanet;
		i++;
	}
	return planets;
}

public static void main(String[] args) {
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double radius = readRadius(filename);
		Planet[] planets = readPlanets(filename);
		StdDraw.setScale(-radius, radius);
		//StdDraw.picture(0,0,"images/starfield.jpg");
		//for (Planet s : planets) {
			//s.draw();
		//}
		StdDraw.enableDoubleBuffering();
		double time = 0;
		while (time<=T) {
			double[] xForces = new double[planets.length];
			double[] yForces = new double[planets.length];
			for (int i = 0; i < planets.length; i++) {
				double xxNetForce = planets[i].calcNetForceExertedByX(planets);
				double yyNetForce = planets[i].calcNetForceExertedByY(planets);
				xForces[i] = xxNetForce;
				yForces[i] = yyNetForce;
				planets[i].update(dt, xxNetForce, yyNetForce);
			}
			StdDraw.picture(0,0,"images/starfield.jpg");
			for (Planet s : planets) {
			s.draw();
			}
			StdDraw.show();
			StdDraw.pause(10);
			time+=dt;
		}
		StdOut.printf("%d\n", planets.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < planets.length; i++) {
			StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
				planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                planets[i].yyVel, planets[i].mass, planets[i].imgFileName);  
		}
	}

}