/*******************************************************************************
 * Copyright (c) 2014 antoniomariasanchez at gmail.com. All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0 which accompanies this distribution, and is
 * available at http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors: antoniomaria - initial API and implementation
 ******************************************************************************/
package net.sf.gazpachoquest.facades;

import net.sf.gazpachoquest.dto.GroupDTO;
import net.sf.gazpachoquest.dto.UserDTO;

public interface GroupFacade {

    GroupDTO save(GroupDTO group);

    GroupDTO findOne(Integer id);

    void delete(Integer id);

    void addUserToGroup(UserDTO userDTO, Integer groupId);

}
