/*
 * Copyright 2025 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.hhos.tools;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

import org.gradle.testkit.runner.BuildResult;
import org.gradle.testkit.runner.GradleRunner;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Functional testing for cleanspring plugin.
 *
 * @author Nisal Bandara
 */
class CleanSpringPluginFunctionalTest {

	@TempDir
	File projectDir;

	private File getBuildFile() {
		return new File(this.projectDir, "build.gradle.kts");
	}

	private File getSettingsFile() {
		return new File(this.projectDir, "settings.gradle.kts");
	}

	@Test
	void canRunTask() throws IOException {
		writeString(getSettingsFile(), "");
		writeString(getBuildFile(), """
				plugins {
				  java
				  id("dev.hhos.tools.cleanspring")
				}""");

		// Run the build
		GradleRunner runner = GradleRunner.create();
		runner.forwardOutput();
		runner.withPluginClasspath();
		runner.withArguments("tasks", "--all");
		runner.withProjectDir(this.projectDir);
		BuildResult result = runner.build();

		// @formatter:off
		assertThat(result.getOutput()).contains(List.of(
				"checkFormat - Run Spring Java formatting checks",
				"checkFormatMain - Run Spring Java formatting checks for main",
				"checkFormatTest - Run Spring Java formatting checks for test",
				"format - Apply Spring Java formatting",
				"formatMain - Apply Spring Java formatting for main",
				"formatTest - Apply Spring Java formatting for test"));
		// @formatter:on
	}

	private void writeString(File file, String string) throws IOException {
		try (Writer writer = new FileWriter(file)) {
			writer.write(string);
		}
	}

}
