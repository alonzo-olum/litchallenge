import java.util.Map;
import java.util.EnumMap;

import java.util.stream.Stream;
import java.util.stream.Collectors;

public enum Phase {
	SOLID, LIQUID, GAS;

	public enum Transition {
		MELT(SOLID, LIQUID), FREEZE(LIQUID, SOLID),
		BOIL(LIQUID, GAS), CONDENSE(GAS, LIQUID),
		SUBLIME(SOLID, GAS), DEPOSIT(GAS, SOLID);
		
		private final Phase from;
		private final Phase to;

		Transition(Phase from, Phase to) {
			this.from = from;
			this.to = to;
		}

		public static final Map<Phase, Map<Phase, Transition>>
			m = Stream.of(values()).collect(Collectors.groupingBy(t -> t.from,
						() -> new EnumMap<>(Phase.class),
						Collectors.toMap(t -> t.to, t -> t,
							(x, y) -> y, () -> new EnumMap<>(Phase.class))));

		public static Transition from(Phase from, Phase to) {
			return m.get(from).get(to);
		}
	}
	
	public static void main(String[] args) {
		/*
		Map<Phase, Transition> transitionMap = Stream.of(Transition.values())
		    .collect(Collectors.toMap(t -> t.to, t -> t,
					(x, y) -> y, () -> new EnumMap<>(Phase.class)));
		for (Map.Entry<Phase, Transition> e : transitionMap.entrySet()) {
			System.out.println(e.getKey() + " " + e.getValue());
		}
		*/
		for (Map.Entry<Phase, Map<Phase, Transition>> entry : Transition.m.entrySet()) {
			Phase phaseAsKey = entry.getKey();
			entry.getValue().entrySet()
				.forEach(e ->
						System.out.printf("%s -> %s is %s\n", phaseAsKey, e.getKey(), e.getValue())
						);
		}
	}
}
