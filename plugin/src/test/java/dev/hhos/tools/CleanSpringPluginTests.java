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

import org.gradle.api.Project;
import org.gradle.api.plugins.JavaPlugin;
import org.gradle.api.tasks.TaskContainer;
import org.gradle.testfixtures.ProjectBuilder;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Unit tests for cleanspring plugin
 *
 * @author Nisal Bandara
 */
class CleanSpringPluginTests {

	@Test
	void pluginRegistersFormattingTasks() {
		Project project = ProjectBuilder.builder().withName("cleanspring-test").build();
		project.getPluginManager().apply(JavaPlugin.class);
		project.getPluginManager().apply(CleanSpringPlugin.class);

		TaskContainer tasks = project.getTasks();

		assertThat(tasks.findByName("checkFormat")).isNotNull();
		assertThat(tasks.findByName("checkFormatMain")).isNotNull();
		assertThat(tasks.findByName("checkFormatTest")).isNotNull();
		assertThat(tasks.findByName("format")).isNotNull();
		assertThat(tasks.findByName("formatMain")).isNotNull();
		assertThat(tasks.findByName("formatTest")).isNotNull();
	}

}
