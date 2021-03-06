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
package edu.uco.cs.v2c.dispatcher.utility;

import org.eclipse.jetty.websocket.api.Session;
import java.util.Map;

/*
 * Some action to be taken by the timer
 * 
 * @author Caleb Power https://github.com/calebpower/timer-demo.git
 * 
 * Adapted for V2C dispatcher under open source by @author
 * Jon Craig
 * 
 * */



public interface TimerAction {
	
	/*
	 * The action
	 * 
	 * @param Session, the associated session
	 * 
	 * */
	
	public void onAction(Session session);
	
}
