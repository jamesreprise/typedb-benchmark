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

package grakn.simulation.grakn.yaml_tool;

import grakn.client.GraknClient;
import grakn.simulation.common.yaml_tool.QueryTemplate;
import grakn.simulation.common.yaml_tool.YAMLLoader;
import graql.lang.Graql;
import graql.lang.query.GraqlInsert;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;

public class GraknYAMLLoader extends YAMLLoader {

    private final GraknClient.Session session;

    public GraknYAMLLoader(GraknClient.Session session, Map<String, Path> accessibleFiles) {
        super(accessibleFiles);
        this.session = session;
    }

    @Override
    protected void parseCSV(QueryTemplate template, CSVParser parser) throws IOException {
        try (GraknClient.Transaction tx = session.transaction(GraknClient.Transaction.Type.WRITE)) {
            for (CSVRecord record : parser.getRecords()) {
                String interpolatedQuery = template.interpolate(record::get);
                GraqlInsert insert = Graql.parse(interpolatedQuery);
                tx.execute(insert);
            }
            tx.commit();
        }
    }
}
