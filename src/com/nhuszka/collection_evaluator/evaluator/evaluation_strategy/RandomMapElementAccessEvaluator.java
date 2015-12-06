package com.nhuszka.collection_evaluator.evaluator.evaluation_strategy;

import java.util.List;
import java.util.Map;

import com.nhuszka.collection_evaluator.generator.DummyObject;

public class RandomMapElementAccessEvaluator extends MapEvaluationStrategy {
	
	@Override
	protected String getDescription() {
		return "Random map element access in nanosec (average on " + NUM_OF_ITERATION + " iteration)";
	}

	@Override
	protected Long computeElapsedNanoSec(Map<DummyObject, DummyObject> map, List<DummyObject> randomKeys) {
		Long totalElapsedNanoSec = 0l;

		for (DummyObject key : randomKeys) {
			Long startTime = System.nanoTime();
			map.get(key);
			Long elapsedNanoSec = System.nanoTime() - startTime;
			totalElapsedNanoSec += elapsedNanoSec;
		}

		return totalElapsedNanoSec / randomKeys.size();
	}
}