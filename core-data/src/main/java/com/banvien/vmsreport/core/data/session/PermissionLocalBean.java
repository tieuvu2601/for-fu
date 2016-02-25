package com.banvien.vmsreport.core.data.session;

import com.banvien.vmsreport.core.data.entity.PermissionEntity;

import javax.ejb.Local;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: DEll
 * Date: 8/18/15
 * Time: 1:01 PM
 * To change this template use File | Settings | File Templates.
 */
@Local
public interface PermissionLocalBean extends GenericSessionBean<PermissionEntity, Long> {

    List<PermissionEntity> findPermissionsNotInUser(Long userId, String permissionFilterCode, String permissionFilterName);

    List<PermissionEntity> findByRole(Long roleId, Long permissionGroupId);

    List<Long> findIdsByRole(Long roleId);

    List<PermissionEntity> findNotInRole(Long roleId, Long permissionGroupId);

    List<PermissionEntity> findPermissionOfUser(Long userId);

    List<PermissionEntity> getPermissionListByPermissionSystem(Long userId);

    List<PermissionEntity> findPermissionsInUser(Long userId, String permissionFilterCode, String permissionFilterName);
}
