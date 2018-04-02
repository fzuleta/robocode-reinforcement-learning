# robocode-reinforcement-learning
This is a **WIP** test on implementing robocode reinforcement learning with dl4j


## IntelliJ setup
 0. Open this folder in intelliJ (wait for all dependencies to load)
 1. Open project structure and set module's output path and test path, to `/my/folder/path/robots`  (change `/my/folder/path/` to the path where this folder exists)
 3. On project structure, import the `libs` folder and  add the libs to the module (right click)
 3. On the `Run/Configuration` add an Application set:
    - Main class: `MainKt`
    - VM option: `-Xmx2048M -Dsun.io.useCanonCaches=false -Ddebug=true  -DNOSECURITY=true `
    - Working directory: `/my/folder/path/` (this folder path)
    - Module: r-nn_main
 4. run.

## Robocode Libs
Official robocode repo: Download
**https://sourceforge.net/projects/robocode/** and place the `/libs` folder into `/libs`