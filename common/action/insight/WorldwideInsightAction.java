/*
 * Copyright (C) 2020 Grakn Labs
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
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package grakn.simulation.common.action.insight;

import grakn.simulation.common.action.read.ReadAction;
import grakn.simulation.common.driver.DbOperation;

import java.util.ArrayList;

public abstract class WorldwideInsightAction<DB_OPERATION extends DbOperation, ACTION_RETURN_TYPE> extends ReadAction<DB_OPERATION, ACTION_RETURN_TYPE> {

    public WorldwideInsightAction(DB_OPERATION dbOperation) {
        super(dbOperation);
    }

    @Override
    protected ArrayList<Object> inputForReport() {
        return new ArrayList<>();
    }
}
