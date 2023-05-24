package pl.kurs.kredyt;

import java.text.DecimalFormat;

import javax.ejb.Stateful;

@Stateful
public class KredytEJB {
	private double procent=0.05;
	private double kwota=1000;
	private double rata;
	private double ilRat=24;

	
	
	public double getProcent() {
		return procent;
	}

	public void setProcent(double procent) {
		this.procent = procent;
	}

	public double getKwota() {
		return kwota;
	}

	public void setKwota(double kwota) {
		System.out.println("setKwota: "+this.hashCode());
		this.kwota = kwota;
	}

	public double getIlRat() {
		return ilRat;
	}

	public void setIlRat(double ilRat) {
		this.ilRat = ilRat;
	}

	public double getRata() {
		System.out.println("getRata: "+this.hashCode());
		obliczRate();
		return rata;
	}

	public KredytEJB() {
		System.out.println("Tworzenie kredytu: "+this.hashCode());
	}

	public KredytEJB(double kwota, double procent, double rat) {
		this.kwota = kwota;
		this.procent = procent;
		this.ilRat = rat;
		this.obliczRate();
	}

	void obliczRate() {
		double wsp = 1 - 1 / Math.pow(1.0 + procent / 12, ilRat);
		wsp = (procent / 12) / wsp;
		rata = wsp * kwota;
	}

	@Override
	public String toString() {
		return "kwota:" + getKwota() + " procent:" + getProcent() + " rat:"
				+ getIlRat() + " rata:"
				+ new DecimalFormat("#.##").format(getRata());
	}

}