/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.xwiki.extension.repository.internal;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.xwiki.extension.CoreExtension;
import org.xwiki.extension.ExtensionDependency;
import org.xwiki.extension.ExtensionException;
import org.xwiki.extension.repository.ExtensionRepository;

public class DefaultCoreExtension implements CoreExtension
{
    private URL url;

    private String id;

    private String version;

    private String type;

    private String description;

    private String author;

    private String website;

    private List<ExtensionDependency> dependencies = new ArrayList<ExtensionDependency>();

    private DefaultCoreExtensionRepository repository;

    public DefaultCoreExtension(String id, String version, String type)
    {
        this.id = id;
        this.version = version;
        this.type = type;
    }

    public DefaultCoreExtension(DefaultCoreExtensionRepository repository, URL url, String id, String version, String type)
    {
        this.repository = repository;

        this.url = url;

        this.id = id;
        this.version = version;
        this.type = type;
    }

    // Extension

    public void download(File file) throws ExtensionException
    {
        // TODO
    }

    public String getId()
    {
        return this.id;
    }

    public String getVersion()
    {
        return this.version;
    }

    public String getType()
    {
        return this.type;
    }

    public String getDescription()
    {
        return this.description;
    }

    public String getAuthor()
    {
        return this.author;
    }

    public String getWebSite()
    {
        return this.website;
    }

    public List<ExtensionDependency> getDependencies()
    {
        return Collections.unmodifiableList(this.dependencies);
    }

    public ExtensionRepository getRepository()
    {
        return this.repository;
    }

    // CoreExtension

    public URL getURL()
    {
        return this.url;
    }

    @Override
    public String toString()
    {
        return getId() + '-' + getVersion();
    }
}
