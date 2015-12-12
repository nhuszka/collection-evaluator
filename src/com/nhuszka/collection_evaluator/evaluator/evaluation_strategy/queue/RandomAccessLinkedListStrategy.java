package com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.nhuszka.collection_evaluator.generator.DummyObject;

public class RandomAccessLinkedListStrategy extends QueueEvaluationStrategy {

	public RandomAccessLinkedListStrategy(Queue<DummyObject> queue) {
		super(queue);
	}

	@Override
	protected String getEvaluationDescription() {
		return "Random queue element access in nanosec " + getEvaluationInfo();
	}

	@Override
	protected List<Long> computeElapsedNanoSeconds() {
		LinkedList<DummyObject> linkedList = new LinkedList<>(queue);

		return computeElapsedNanoSecForRandomElementAccess(linkedList);
	}

	protected List<Long> computeElapsedNanoSecForRandomElementAccess(LinkedList<DummyObject> linkedList) {
		List<Long> elapsedNanoSeconds = new ArrayList<>();
		
		List<DummyObject> elementsInQueue = new ArrayList<>(linkedList);
		List<DummyObject> randomElements = computeRandomElements();
		for (DummyObject element : randomElements) {
			Integer index = elementsInQueue.indexOf(element);

			Long startTime = System.nanoTime();
			linkedList.get(index);
			Long elapsedNanoSec = System.nanoTime() - startTime;
			
			elapsedNanoSeconds.add(elapsedNanoSec);
		}

		return elapsedNanoSeconds;
	}
}