package pl.kurs.kredyt;

import javax.ejb.Local;


@Local
public interface Kredyt {

	public abstract double getRata(double kwota);

}