import static java.lang.Math.sqrt;
import static java.lang.Math.pow;


public class Planet {
/** */
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	static final double gConstant = 6.67e-11;

	public Planet(double xP, double yP, double xV, double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
}

	public Planet(Planet p) {
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass = p.mass;
		imgFileName = p.imgFileName;
	}

	public double calcDistance (Planet q) {
		double xxD = this.xxPos - q.xxPos;
		double yyD = this.yyPos - q.yyPos;
		double rSquared = (xxD*xxD) + (yyD*yyD);
		double distance = sqrt(rSquared);
		return distance;
	}

	public double calcForceExertedBy (Planet q) {
		double Force = (gConstant*this.mass*q.mass)/pow(calcDistance(q),2);
		return Force;
	}

	public double calcForceExertedByX (Planet q) {
		double xxD = q.xxPos - this.xxPos;
		double xxForce = (xxD*calcForceExertedBy(q))/calcDistance(q);
		return xxForce;
	}

	public double calcForceExertedByY (Planet q) {
		double yyD = q.yyPos - this.yyPos;
		double yyForce = (yyD*calcForceExertedBy(q))/calcDistance(q);
		return yyForce;
	}

	public double calcNetForceExertedByX (Planet[] planetArray) {
		double xxNetForce = 0;
		for (int i = 0; i < planetArray.length; i++) {
			if (this.equals(planetArray[i])) {
				continue;
			}
			xxNetForce += calcForceExertedByX(planetArray[i]);
		}
		return xxNetForce;
	}

	public double calcNetForceExertedByY (Planet[] planetArray) {
		double yyNetForce = 0;
		for (int i = 0; i < planetArray.length; i++) {
			if (this.equals(planetArray[i])) {
				continue;
			}
			yyNetForce += calcForceExertedByY(planetArray[i]);
		}
		return yyNetForce;
	}

	public void update(double dt, double fX, double fY) {
		double aXX = fX/mass;
		double aYY = fY/mass;

		xxVel = xxVel + (dt*aXX);
		yyVel = yyVel + (dt*aYY);
		xxPos = xxPos + (dt*xxVel);
		yyPos = yyPos + (dt*yyVel);

	}
	public void draw() {
		StdDraw.picture(xxPos,yyPos,imgFileName);
	}

}

