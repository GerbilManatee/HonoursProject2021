# HonoursProject2021
Due to unfamiliarity with GitHub, the source code for the honours project artefact is in the AddTwister directory on GitHub.
The executable is in https://github.com/GerbilManatee/HonoursProject2021/tree/AddTwister/src/montecarlosim.
MonteCarloSim.java creates MonteCarloSimController, which in turn creates ShapedAttacker, ShapedEstate, LogArray and LogInterpreter.
LogArray creates ResultLogs, Estate creates Nodes.

The DAOs are currently legacy code, and need substantial updating to bring them to import data from YAML files (proposed to use Jackson for managing this).

The code-enforced limit of 1,000,000 iterations on the Monte Carlo simulation borders on arbitrary.  For smaller numbers of lateral moves a million repetitions
takes under 2 minutes on a relatively modern laptop - fast enough to generate data in volume.  Getting noticeably higher quality of data would probably require
2x or 10x more iterations, and anyone with the desire to do that will know enough to modify the code themselves.

The app is single threaded, and runs that core quite hard while running.  Memory usage is proportional to depth and number of runs the attacker makes.
