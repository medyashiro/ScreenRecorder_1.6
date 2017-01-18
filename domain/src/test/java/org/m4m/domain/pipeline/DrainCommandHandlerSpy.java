/*
 * Copyright 2014-2016 Media for Mobile
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.m4m.domain.pipeline;

import org.m4m.domain.Encoder;
import org.m4m.domain.VideoDecoder;
import org.m4m.domain.dsl.CommandProcessorSpy;

public class DrainCommandHandlerSpy extends DrainCommandHandler {
    private final VideoDecoder decoder;
    private final CommandProcessorSpy commandProcessorSpy;

    public DrainCommandHandlerSpy(VideoDecoder decoder, Encoder encoder, CommandProcessorSpy commandProcessorSpy) {
        super(encoder);
        this.decoder = decoder;
        this.commandProcessorSpy = commandProcessorSpy;
    }

    @Override
    public void handle() {
        commandProcessorSpy.logPair(decoder, plugin);
        super.handle();
    }
}
