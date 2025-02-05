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

package com.vaticle.typedb.benchmark.common.concept;

import java.util.Objects;

public class Parenthood {

    private final Person mother;
    private final Person father;
    private final Person child;

    public Parenthood(Person mother, Person father, Person child) {
        this.mother = mother;
        this.father = father;
        this.child = child;
    }

    public Person mother() {
        return mother;
    }

    public Person father() {
        return father;
    }

    public Person child() {
        return child;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parenthood that = (Parenthood) o;
        return mother.equals(that.mother) &&
                father.equals(that.father) &&
                child.equals(that.child);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mother, father, child);
    }
}
