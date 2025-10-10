import java.util.ArrayList;

public class SkylineProblem {

	ArrayList<Building> buildings = new ArrayList<>();
	int count = 0;
	/*
	 * add a skyline
	 * @param start starting coordinate of building
	 * @param height height of building
	 * @param end ending coordinate of building
	 * */
	public void add(int start, int height, int end) {
		buildings.add(count++, new Building(start, height, end));
	}

	/*
	 * divide the list of skylines recursively
	 * merge each individual building coordinate on solving each subproblem
	 * @param start starting index of building to scan
	 * @param end ending index of building to scan
	 * */
	public ArrayList<Skyline> findSkyline(int start, int end) {
		// Base Case: we have one building

		ArrayList<Skyline> list = new ArrayList<>();
		if (start == end) {
			Building building = buildings.get(start);
			list.add(new Skyline(building.start, building.height));
			list.add(new Skyline(building.end, 0));
			return list;
		}
		// divide whole list into equal sub-problems
		int mid = (start + end) / 2;
		ArrayList<Skyline> sky1 = this.findSkyline(start, mid);

		ArrayList<Skyline> sky2 = this.findSkyline(mid+1, end);
		return mergeSkyline(sky1, sky2);
	}

	public ArrayList<Skyline> mergeSkyline(ArrayList<Skyline> sky1, ArrayList<Skyline> sky2) {
		int current_height = 0;
		int next_height = 0;
		ArrayList<Skyline> skyline = new ArrayList<>();
		int max_height = 0;

		// merge two skylines
		while (!sky1.isEmpty() && !sky2.isEmpty()) {
			if (sky1.get(0).coordinates < sky2.get(0).coordinates) {
				int current_start = sky1.get(0).coordinates;
				current_height = sky1.get(0).height;

				if (current_height < next_height) {
					sky1.remove(0);
					if (max_height != next_height) {
						skyline.add(new Skyline(current_start, next_height));
					}
				} else {
					max_height = current_height;
					sky1.remove(0);
					skyline.add(new Skyline(current_start, current_height));
				}
			} else {
				int current_start = sky2.get(0).coordinates;
				current_height = sky2.get(0).height;

				if (next_height < current_height) {
					sky2.remove(0);
					if (max_height != current_height) {
						skyline.add(new Skyline(current_start, current_height));
					}
				} else {
					max_height = next_height;
					sky2.remove(0);
					skyline.add(new Skyline(current_start, next_height));
				}
			}
		}
		// Any remaining points from sky1 or sky2
		while (!sky1.isEmpty()) {
			skyline.add(sky1.get(0));
			sky1.remove(0);
		}

		while (!sky2.isEmpty()) {
			skyline.add(sky2.get(0));
			skyline.remove(0);
		}

		return skyline;
	}

	private static class Skyline {
		int coordinates, height;

		Skyline(int coordinates, int height) {
			this.coordinates = coordinates;
			this.height = height;
		}
	}

	private static class Building {
		public int start, height, end;

		Building(int start, int height, int end) {
			this.start = start;
			this.height = height;
			this.end = end;
		}

	}
}
