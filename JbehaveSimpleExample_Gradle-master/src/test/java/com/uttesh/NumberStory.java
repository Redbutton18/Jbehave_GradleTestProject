package com.uttesh;

import static org.jbehave.core.reporters.Format.CONSOLE;
import static org.jbehave.core.reporters.Format.HTML;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.jbehave.core.Embeddable;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;

public class NumberStory extends JUnitStories {

	@Override
	public Configuration configuration() {
		Class<? extends Embeddable> embeddableClass = this.getClass();
		return new MostUsefulConfiguration().useStoryLoader(new LoadFromClasspath(embeddableClass))
				.useStoryReporterBuilder(new StoryReporterBuilder()
						.withCodeLocation(CodeLocations.codeLocationFromClass(embeddableClass)).withDefaultFormats()
						.withFormats(CONSOLE, HTML).withFailureTrace(true).withFailureTraceCompression(true));
	}

	@Override
	public InjectableStepsFactory stepsFactory() {
		List<Object> instances = new ArrayList<>();
		instances.add(new DummySteps());
		instances.add(new LogicSteps());
		return new InstanceStepsFactory(configuration(), instances);
	}

	@Override
	protected List<String> storyPaths() {
		return Arrays.asList("number_story.story");
	}
}
