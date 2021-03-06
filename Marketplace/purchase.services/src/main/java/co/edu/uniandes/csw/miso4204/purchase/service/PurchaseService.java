/* ========================================================================
 * Copyright 2014 miso4204
 *
 * Licensed under the MIT, The MIT License (MIT)
 * Copyright (c) 2014 miso4204

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 * ========================================================================


Source generated by CrudMaker version 1.0.0.qualifier

*/

package co.edu.uniandes.csw.miso4204.purchase.service;

import co.edu.uniandes.csw.miso4204.purchase.logic.dto.PurchasePageDTO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/purchases")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PurchaseService extends _PurchaseService {

    
        @GET
        @Path("search/{ini_date}/{end_date}/{id_purchase}")
	public PurchasePageDTO getPurchasesSearch(@QueryParam("page") Integer page, @QueryParam("maxRecords") Integer maxRecords, @PathParam("ini_date") String ini_date, @PathParam("end_date") String end_date, @PathParam("id_purchase") Long id_purchase){            
            return purchaseLogicService.getPurchasesSearch(page, maxRecords, ini_date, end_date, id_purchase);
        }

        @GET
        @Path("buyer/{id_buyer}")
	public PurchasePageDTO getPurchasesBuyer(@QueryParam("page") Integer page, @QueryParam("maxRecords") Integer maxRecords, @PathParam("id_buyer") Long id){
		return purchaseLogicService.getPurchasesBuyer(page, maxRecords, id);
        }
}