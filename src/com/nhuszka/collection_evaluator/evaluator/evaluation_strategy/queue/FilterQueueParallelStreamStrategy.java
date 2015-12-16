package com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.queue;

import java.util.Queue;
import java.util.stream.Collectors;

import com.nhuszka.collection_evaluator.generator.DummyObject;
import com.nhuszka.collection_evaluator.message.Texts;

public class FilterQueueParallelStreamStrategy extends FilterQueueStreamStrategy {

	public FilterQueueParallelStreamStrategy(Queue<DummyObject> queue, Queue<DummyObject> queueToTest) {
		super(queue, queueToTest);
	}

	@Override
	protected String getEvaluationTitle() {
		return Texts.FILTER_QUEUE_STREAM_PARALLEL_STRATEGY_TITLE;
	}

	@Override
	protected void filterStream() {
		queueToTest
				.parallelStream()
				.filter(item -> item.toString().contains("a"))
				.collect(Collectors.toList());
	}
}
