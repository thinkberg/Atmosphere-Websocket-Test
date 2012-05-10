/*
 * Copyright (c) 2011 TWIMPACT UG (haftungsbeschraenkt). All rights reserved.
 */

package twimpact

import javax.servlet.http.HttpServletRequest

/**
 * Allow Cross Origin Requests (CORS).
 * TODO: check whether the old Chrome check is removed (isEnabled)
 *
 * @author Matthias L. Jugel
 */

class CrossOriginFilter extends org.eclipse.jetty.servlets.CrossOriginFilter {
  override def isEnabled(request: HttpServletRequest) = true
}