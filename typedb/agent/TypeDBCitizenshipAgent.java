/*
 * Copyright (C) 2022 Vaticle
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

package com.vaticle.typedb.benchmark.typedb.agent;

import com.vaticle.typedb.benchmark.common.concept.Country;
import com.vaticle.typedb.benchmark.common.params.Context;
import com.vaticle.typedb.benchmark.simulation.agent.CitizenshipAgent;
import com.vaticle.typedb.benchmark.simulation.driver.Client;
import com.vaticle.typedb.benchmark.typedb.driver.TypeDBTransaction;
import com.vaticle.typedb.client.api.answer.ConceptMap;
import com.vaticle.typeql.lang.TypeQL;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static com.vaticle.typedb.benchmark.typedb.Labels.BIRTH_DATE;
import static com.vaticle.typedb.benchmark.typedb.Labels.CITIZEN;
import static com.vaticle.typedb.benchmark.typedb.Labels.CITIZENSHIP;
import static com.vaticle.typedb.benchmark.typedb.Labels.CODE;
import static com.vaticle.typedb.benchmark.typedb.Labels.COUNTRY;
import static com.vaticle.typedb.benchmark.typedb.Labels.PERSON;
import static com.vaticle.typeql.lang.TypeQL.rel;
import static com.vaticle.typeql.lang.TypeQL.var;

public class TypeDBCitizenshipAgent extends CitizenshipAgent<TypeDBTransaction> {


    public TypeDBCitizenshipAgent(Client<?, TypeDBTransaction> client, Context context) {
        super(client, context);
    }

    @Override
    protected void matchCitizenship(TypeDBTransaction tx, Country country, LocalDateTime today) {
        List<ConceptMap> answers = tx.query().match(TypeQL.match(
                var(COUNTRY).isa(COUNTRY).has(CODE, country.code()),
                var(CITIZEN).isa(PERSON).has(BIRTH_DATE, today),
                rel(CITIZEN, CITIZEN).rel(COUNTRY, COUNTRY).isa(CITIZENSHIP)
        )).collect(Collectors.toList());
    }

}
