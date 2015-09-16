#!/bin/bash

# This is update.sh, a tool for migrating the src directory
# into a format of files which BlueJ can understand. There
# are some major differences between how BlueJ and, say,
# eclipse handle their source files.

# Namespacing
#  BlueJ really doesn't have the idea of "packages" like every
#  other java editor does, so this script will remove all of
#  the package and import statements.

# Structure
#  Because BlueJ doesn't understand packages (which is silly),
#  it can't understand a directory structure that isn't
#  "let's dump everything into the same folder and run with that",
#  so this will also just dump everything in the same folder.
#  technically, BlueJ can understand directory structure, but
#  it struggles linking code across files.

# WARNINGS
## DO NOT use the keyword "import" anywhere but imports

# Structure #

# Structure announcement
echo "Attempting restructure"

# Move the files ending in .java into the BlueJ
find src -type f -iname "*.java" -exec cp -t bluej/ {} +

# Namespacing #

# Namespacing announcement
echo "Attempting import / package pruning"

# For every source file, remove lines containing import
for file in ./bluej/*.java
do
    echo "Pruning $file"
    sed -i '/import e/d' $file
    sed -i '/package/d' $file
    echo "$file Pruned"
    echo ""
done

# Everything went well? Say so.
echo "BlueJ migration complete. Good job :)"
