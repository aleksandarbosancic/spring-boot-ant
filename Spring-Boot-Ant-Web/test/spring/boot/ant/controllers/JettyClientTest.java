/*
 * Copyright (c) 2017
 * AlphaGate Automatisierungstechnik, Rankweil, Austria  * 
 * @author      original: abo, last edit: $Author$
 * @version     $Id$
 */
package spring.boot.ant.controllers;

/**
 *
 * @author abosancic
 */
/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.net.URI;
import java.util.Arrays;
import org.hamcrest.Matchers;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHttpHeaders;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.jetty.JettyWebSocketClient;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import spring.boot.ant.SpringBootAnt;
import spring.boot.ant.websockets.handlers.MyTextHandler;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootAnt.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class JettyClientTest {

    @LocalServerPort
    private int port;
    
//    private static String WS_URI = "ws://localhost:8080/echo";
    private String wsUrl;

    private JettyWebSocketClient client;
    private WebSocketSession wsSession;
    
    @MockBean
    MyTextHandler handler;

    @Before
    public void setup() throws Exception
    {

        this.client = new JettyWebSocketClient();
        this.client.start();

        this.wsUrl = "ws://localhost:" + port + "/text";
    }

    @Test
    public void doHandshake() throws Exception
    {

        WebSocketHttpHeaders headers = new WebSocketHttpHeaders();
        headers.setSecWebSocketProtocol(Arrays.asList("text"));

        ListenableFuture<WebSocketSession> future = this.client.doHandshake(new TextWebSocketHandler(), headers, new URI(this.wsUrl));
//        future.addCallback((WebSocketSession t) ->
//        {
//            t.
//        });
        this.wsSession = future.get();
        
        assertTrue(wsSession.isOpen());
        assertEquals(this.wsUrl, this.wsSession.getUri().toString());
        
        String expected = "foo,bar";
        TextMessage actual = new TextMessage(expected);
        wsSession.sendMessage(actual);
        assertThat(actual.getPayload(), Matchers.is(expected));
        
//        assertEquals("text", this.wsSession.getAcceptedProtocol());
    }

}

