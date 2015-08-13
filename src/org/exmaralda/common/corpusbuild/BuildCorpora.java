/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.exmaralda.common.corpusbuild;

// IMPORTANT! You need to compile this class against ant.jar.
// The easiest way to do this is to add ${ant.core.lib} to your project's classpath.
// For example, for a plain Java project with no other dependencies, set in project.properties:
// javac.classpath=${ant.core.lib}

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;

/**
 * @author thomas
 */
public class BuildCorpora extends Task {

   // TODO customize method names to match custom task
   // property and type (handled by inner class) names

    /* For a simple option:
    private boolean opt;
    public void setOpt(boolean b) {
        opt = b;
    }
    // <customtask opt="true"/>
    */

    /* For a simple property based on a string:
    private String myprop;
    public void setMyprop(String s) {
        myprop = s;
    }
    // <customtask myprop="some text here"/>
    */

    /* For a simple property based on a file:
    private File myfile;
    public void setMyfile(File f) {
        // Note: f will automatically be absolute (resolved from project basedir).
        myfile = f;
    }
    // <customtask myfile="foo.txt"/>
    */

    /* Custom nested elements:
    public static class Nestme {
        String val; // accessible from execute()
        public void setVal(String s) {
            val = s;
        }
    }
    private List<Nestme> nestmes = new LinkedList<Nestme>();
    public Nestme createNestme() {
        Nestme n = new Nestme();
        nestmes.add(n);
        return n;
    }
    // Or:
    public void addNestme(Nestme n) {
        nestmes.add(n);
    }
    // <customtask>
    //     <nestme val="something"/>
    // </customtask>
    */

    /* To add embedded filesets:
    private List<FileSet> filesets = new LinkedList<FileSet>();
    public void addFileset(FileSet fs) {
        filesets.add(fs);
    }
    // <customtask>
    //     <fileset dir="foo">
    //         <include name="*.txt"/>
    //     </fileset>
    // </customtask>
    // In execute() you can do:
    for (FileSet fs : filesets) {
        DirectoryScanner ds = fs.getDirectoryScanner(project);
        File basedir = ds.getBasedir();
        for (String file : ds.getIncludedFiles()) {
            // process it...
        }
    }
    */

    /* For nested text:
    private StringBuilder text;
    public void addText(String raw) {
        String s = getProject().replaceProperties(raw.trim());
        if (text == null) {
            text = new StringBuilder(s);
        } else {
            text.append(s);
        }
    }
    // <customtask>
    //     Some text...
    // </customtask>
    */

    /* Some sort of path (like classpath or similar):
    private Path path;
    public void setPath(Path p) {
        if (path == null) {
            path = p;
        } else {
            path.append(p);
        }
    }
    public Path createPath () {
        if (path == null) {
            path = new Path(project);
        }
        return path.createPath();
    }
    public void setPathRef(Reference r) {
        createPath().setRefid(r);
    }
    // <customtask path="foo:bar"/>
    // <customtask>
    //     <path>
    //         <pathelement location="foo"/>
    //     </path>
    // </customtask>
    // Etc.
    */

    /* One of a fixed set of choices:
    public static class FooBieBletch extends EnumeratedAttribute { // or use Java 5 enums
        public String[] getValues() {
            return new String[] {"foo", "bie", "bletch"};
        }
    }
    private String mode = "foo";
    public void setMode(FooBieBletch m) {
        mode = m.getValue();
    }
    // <customtask mode="bletch"/>
    */

    public @Override void execute() throws BuildException {
        // TODO code here what the task actually does:

        // To log something:
        // log("Some message");
        // log("Serious message", Project.MSG_WARN);
        // log("Minor message", Project.MSG_VERBOSE);

        // To signal an error:
        // throw new BuildException("Problem", location);
        // throw new BuildException(someThrowable, location);
        // throw new BuildException("Problem", someThrowable, location);

        // You can call other tasks too:
        // Zip zip = (Zip)project.createTask("zip");
        // zip.setZipfile(zipFile);
        // FileSet fs = new FileSet();
        // fs.setDir(baseDir);
        // zip.addFileset(fs);
        // zip.init();
        // zip.setLocation(location);
        // zip.execute();
    }

}
