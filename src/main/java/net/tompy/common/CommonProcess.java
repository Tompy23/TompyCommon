/*---------------------------------------------------------------------
 * 
 * Copyright 2011 TransUnion LLC. All Rights Reserved.
 * 
 * No part of this work may be reproduced or distributed in any form or by any
 * means, electronic or otherwise, now known or hereafter developed, including,
 * but not limited to, the Internet, without the explicit prior written consent
 * from TransUnion LLC.
 * 
 * Requests for permission to reproduce or distribute any part of, or all of,
 * this work should be mailed to:
 * 
 * Law Department TransUnion 555 West Adams Chicago, Illinois 60661
 * www.transunion.com
 * 
 * ---------------------------------------------------------------------*/
package net.tompy.common;

import java.util.Properties;

import org.springframework.context.ApplicationContext;

public interface CommonProcess 
{
	/**
	 * 
	 * @param ctx
	 * @param properties
	 * @return
	 */
	public int process( ApplicationContext ctx, Properties properties );
}
