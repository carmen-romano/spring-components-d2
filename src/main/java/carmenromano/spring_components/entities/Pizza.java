package carmenromano.spring_components.entities;

import lombok.Getter;

import java.util.List;

@Getter
public class Pizza extends Item {
	private String name;

	private List<Topping> toppingList;
	private boolean isXl = false;

	public Pizza(String name, List<Topping> toppingList, boolean isXl) {
		super(1012, 4.3);
		this.name = name;
		this.toppingList = toppingList;
		this.isXl = isXl;
		this.calories = setCalories(toppingList, isXl);
		this.price = setPrice(toppingList, isXl);
	}

	public int setCalories(List<Topping> toppingList, boolean isXl) {
		int tot = 1012;
		if (toppingList != null) {
			for (int i = 0; i < toppingList.size(); i++) {
				tot += toppingList.get(i).getCalories();
			}
		}
		if (isXl) return (tot += (tot * 5) / 100);
		else return tot;
	}

	public double setPrice(List<Topping> t, boolean isXl) {
		double tot = 4.30;
		if (t != null) {
			for (int i = 0; i < t.size(); i++) {
				tot += t.get(i).getPrice();
			}
		}

		if (isXl) return tot += (tot * 10) / 100;
		else return tot;
	}

	@Override
	public String toString() {
		return "Pizza{" +
				"name='" + name + '\'' +
				", calories=" + calories +
				", price=" + price +
				", toppingList=" + toppingList +
				", isXl=" + isXl +
				'}';
	}
}
