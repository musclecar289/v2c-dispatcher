/*
 * Copyright (c) 2020 Caleb L. Power, Everistus Akpabio, Rashed Alrashed,
 * Nicholas Clemmons, Jonathan Craig, James Cole Riggall, and Glen Mathew.
 * All rights reserved. Licensed under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package edu.uco.cs.v2c.dispatcher.net.websocket.incoming;

import org.json.JSONException;
import org.json.JSONObject;

import edu.uco.cs.v2c.dispatcher.net.websocket.PayloadHandlingException;
import edu.uco.cs.v2c.dispatcher.net.websocket.incoming.IncomingPayload.IncomingAction;

/**
 * Encapsulates the incoming {@link IncomingAction#REGISTER_LISTENER} payload.
 * 
 * @author Caleb L. Power
 */
public class RegisterListenerPayload extends IncomingPayload {

  private static final String APP_VAR = "app";
  private static final String EAVESDROP_VAR = "eavesdrop";
  
  private boolean eavesdrop = false;
  private String app = null;
  
  /**
   * Instantiates the REGISTER_LISTENER payload.
   * 
   * @param raw the raw JSON
   * @throws PayloadHandlingException if the payload was invalid
   */
  public RegisterListenerPayload(JSONObject raw) throws PayloadHandlingException {
    super(raw, IncomingAction.REGISTER_LISTENER);
    
    try {
      eavesdrop = raw.getBoolean(EAVESDROP_VAR);
      app = raw.getString(APP_VAR).toLowerCase();
    } catch(JSONException e) {
      throw new PayloadHandlingException(action, e, raw);
    }
  }
  
  /**
   * Determines whether or not the listener in question is an eavesdropper.
   * Eavesdroppers are sent messages on the traffic not explicitly designated to them.
   * 
   * @return <code>true</code> if the app is an eavesdropper
   */
  public boolean isEavesdropper() {
    return eavesdrop;
  }
  
  /**
   * Retrieves the unique identifier of the application in question.
   * 
   * @return the application's unique identifier
   */
  public String getApp() {
    return app;
  }

}
