/*
 * Aipo is a groupware program developed by TOWN, Inc.
 * Copyright (C) 2004-2015 TOWN, Inc.
 * http://www.aipo.com
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.aimluck.eip.modules.actions.license;

import org.apache.jetspeed.portal.portlets.VelocityPortlet;
import org.apache.jetspeed.services.logging.JetspeedLogFactoryService;
import org.apache.jetspeed.services.logging.JetspeedLogger;
import org.apache.turbine.util.RunData;
import org.apache.velocity.context.Context;

import com.aimluck.eip.license.LicenseSelectData;
import com.aimluck.eip.modules.actions.common.ALBaseAction;

/**
 * 検索窓のアクションクラスです。
 * 
 */
public class LicenseAction extends ALBaseAction {

  /** logger */
  @SuppressWarnings("unused")
  private static final JetspeedLogger logger = JetspeedLogFactoryService
    .getLogger(LicenseAction.class.getName());

  /**
   * 通常表示の際の処理を記述します。
   * 
   * @param portlet
   * @param context
   * @param rundata
   * @throws Exception
   */
  @Override
  protected void buildNormalContext(VelocityPortlet portlet, Context context,
      RunData rundata) throws Exception {
    doLicense_detail(rundata, context);
  }

  /**
   * ライセンス情報を表示する．
   * 
   * @param rundata
   * @param context
   * @throws Exception
   */
  public void doLicense_detail(RunData rundata, Context context)
      throws Exception {
    LicenseSelectData detailData = new LicenseSelectData();
    detailData.initField();
    detailData.doViewDetail(this, rundata, context);
    setTemplate(rundata, "license");
  }
}
