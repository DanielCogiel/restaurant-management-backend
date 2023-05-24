package pl.kurs.komis;

import javax.ejb.Local;

@Local
public interface Komis {

	public abstract String create(Car car);

	public abstract Car find(int idc);

	public abstract Cars get();

	public abstract String update(Car car);

	public abstract void delete(int idc);

}