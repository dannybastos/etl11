/**
 * Copyright 2016 Red Hat, Inc.
 * 
 * Red Hat licenses this file to you under the Apache License, version
 * 2.0 (the "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.  See the License for the specific language governing
 * permissions and limitations under the License.
 * 
 */
package org.jboss.quickstarts.fuse.sap_trfc_destination_spring_boot;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.apache.camel.Exchange;
import org.fusesource.camel.component.sap.SapSynchronousRfcDestinationEndpoint;
import org.fusesource.camel.component.sap.model.rfc.Structure;

/**
 * A {@link CreateRequest} is a processor bean which builds a request to the
 * CreateFromData method of the FlightCustomer BAPI to create a flight customer
 * record in SAP for 'Fred Flintstone'.
 * 
 * @author William Collins (punkhornsw@gmail.com)
 *
 */
public class CreateRequest {

	public void createRequest(Exchange exchange) throws Exception {
		SapSynchronousRfcDestinationEndpoint endpoint = exchange.getContext()
				.getEndpoint("sap-srfc-destination:quickstartDest:ZDIFF001", SapSynchronousRfcDestinationEndpoint.class);
		Structure request = endpoint.createRequest();

		Calendar calendar = new GregorianCalendar(2018, 10, 5);

		// request.put("DATA", row.getDataProcesso());
		request.put("DATA", calendar.getTime());
		request.put("LOJA", "1004");

		exchange.getOut().setBody(request);
	}

}
