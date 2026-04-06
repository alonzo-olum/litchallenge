import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.stream.Collectors;

public class SkylineProblem {
	public static void main(String[] args) {
		SkylineProblem.Builder builder = new SkylineProblem.Builder()
			.add(new int[][]{{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}});
		List<Building> buildings = builder.build();

		List<Skyline> result = SkylineProblem.findSkyline(buildings);
		result.stream().forEach(s -> System.out.println("["+s.coordinate+", "+s.height+"]"));
	}

	private static class Builder {
		private List<Building> buildings;
	 /*
	  * add a skyline
	  * @param array of building coordinates [{left, right, height},...]
	 * */
		public Builder add(int[][] builds) {
			buildings = Arrays.stream(builds)
				.map(b -> new Building(b[0], b[2], b[1]))
				.collect(Collectors.toList());
			//buildings = Arrays.stream(builds).collect(ArrayList::new, (list, b) -> list.add(new Building(b[0], b[2], b[1])), ArrayList::addAll);
			return this;
		}

		public List<Building> build() {
			return this.buildings;
		}
	}

	/*
	 * find a skyline given a list of building coordinates
	 * @param List<Building>
	 * */
	public static List<Skyline> findSkyline(List<Building> buildings) {
		if (buildings.isEmpty()) {
			new ArrayList<>();
		}
		return divideConquer(buildings, 0, buildings.size() - 1);
	}

	/*
	 * divide the list of skylines recursively
	 * merge each individual building coordinate on solving each subproblem
	 * @param start starting index of building to scan
	 * @param end ending index of building to scan
	 * */
	private static List<Skyline> divideConquer(List<Building> buildings, int left, int right) {
		// Base Case: we have one building
		if (left == right) {
			List<Skyline> result = new ArrayList<>();
			int l = buildings.get(left).start;
			int r = buildings.get(left).end;
			int height = buildings.get(left).height;
			result.add(new Skyline(l, height));
			result.add(new Skyline(r, 0));
			return result;
		}

		int mid = left + (right-left) / 2;
		List<Skyline> leftSky = divideConquer(buildings, left, mid);
		List<Skyline> rightSky = divideConquer(buildings, mid + 1, right);

		return mergeSkyline(leftSky, rightSky);
	}

	/*
	 * merge each soleved subproblem to the recurring solved subproblem
	 * @param List<Skyline> left
	 * @param List<Skyline> right
	 */
	private static List<Skyline> mergeSkyline(List<Skyline> start, List<Skyline> end) {
		List<Skyline> result = new ArrayList<>();

		int i = 0, j = 0;
		int h1 = 0, h2 = 0;

		while (i < start.size() || j < end.size()) {
			long startX = (i < start.size()) ? start.get(i).coordinate : Long.MAX_VALUE;
			long endX = (j < end.size()) ? end.get(j).coordinate : Long.MAX_VALUE;

			if (startX < endX) {
				// case where left lt than right
				h1 = start.get(i).height;
				addPoint(result, (int)startX, Math.max(h1, h2));
				i++;
			} else if(startX > endX) {
				// case where left gt than right
				h2 = end.get(j).height;
				addPoint(result, (int)endX, Math.max(h1, h2));
				j++;
			} else {
				// case where left eq to right
				h1 = start.get(i).height;
				h2 = end.get(j).height;
				addPoint(result, (int)startX, Math.max(h1, h2));
				i++;
				j++;
			}
		}

		return result;
	}

	/*
	 * add point acts as a visitor method that populates the actual skyline
	 * @param List<Skyline>
	 * @param int [x coordinate]
	 * @param int [height]
	 */
	private static void addPoint(List<Skyline> result, int x, int h) {
		if (result.isEmpty() || result.get(result.size() - 1).height != h) {
			result.add(new Skyline(x, h));
			// For debugging purposes
			//System.out.println("Added point: [x, h] :["+ x +", "+ h +"]");
		}
	}

	private static class Skyline {
		int coordinate, height;

		Skyline(int coordinate, int height) {
			this.coordinate = coordinate;
			this.height = height;
		}
	}

	private static class Building {
		int start, height, end;

		Building(int start, int height, int end) {
			this.start = start;
			this.height = height;
			this.end = end;
		}
	}
}
