#
# Copyright (C) 2022 Vaticle
#
# This program is free software: you can redistribute it and/or modify
# it under the terms of the GNU Affero General Public License as
# published by the Free Software Foundation, either version 3 of the
# License, or (at your option) any later version.
#
# This program is distributed in the hope that it will be useful,
# but WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
# GNU Affero General Public License for more details.
#
# You should have received a copy of the GNU Affero General Public License
# along with this program.  If not, see <https://www.gnu.org/licenses/>.
#

load("@bazel_tools//tools/build_defs/repo:git.bzl", "git_repository")

def vaticle_dependencies():
    git_repository(
        name = "vaticle_dependencies",
        remote = "https://github.com/vaticle/dependencies",
        commit = "a8b3b714a5e0562d41f4c05ca8f266d48b7d0fd3",  # sync-marker: do not remove this comment, this is used for sync-dependencies by @vaticle_dependencies
    )

def vaticle_typedb_client_java():
    git_repository(
        name = "vaticle_typedb_client_java",
        remote = "https://github.com/vaticle/typedb-client-java",
        commit = "5717b9cb0c63e0e1c4457ad8e5ad5141d3f04556",  # sync-marker: do not remove this comment, this is used for sync-dependencies by @vaticle_typedb_client_java
    )

def vaticle_factory_tracing():
    git_repository(
        name = "vaticle_factory_tracing",
        remote = "https://github.com/vaticle/factory-tracing",
        commit = "a4d5e36b1b0c56bd370e5a7583d628de9272f086"  # sync-marker: do not remove this comment, this is used for sync-dependencies by @vaticle_factory_tracing
    )
